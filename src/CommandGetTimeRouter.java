import java.io.IOException;
import java.net.Socket;

public class CommandGetTimeRouter implements SocketServer.IRouter
{
    @Override
    public void route(Socket client)
    {
        try
        {
            SocketIO.write(client, "Boom!!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
