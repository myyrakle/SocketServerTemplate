import java.io.IOException;
import java.net.ServerSocket;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            SocketServer server = new SocketServer(12345);
            server.addRouter("get_text", new CommandGetTextRouter());

            server.run();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}