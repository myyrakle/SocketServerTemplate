import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class SocketServer
{
    public interface IRouter
    {
        public abstract void route(Socket client);
    }

    private ServerSocket serverSocket=null;
    private static final int BUFFER_SIZE = 1024;
    private HashMap<String, IRouter> routerMap = new HashMap<>();

    //단일 생성자.
    public SocketServer(int port) throws IOException
    {
        serverSocket = new ServerSocket(port);
    }

    //라우터 추가
    public void addRouter(String command, IRouter router)
    {
        routerMap.put(command, router);
    }

    //서버 구동
    public void run()
    {
        while(true)
        {
            try
            {
                Socket client = serverSocket.accept();

                byte[] buffer = new byte[BUFFER_SIZE];
                client.getInputStream().read(buffer);

                //...파싱
                String command = "";
                routerMap.get(command).route(client);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
