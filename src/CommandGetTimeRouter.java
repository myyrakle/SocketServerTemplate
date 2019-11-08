import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

public class CommandGetTimeRouter implements SocketServer.IRouter
{
    @Override
    public void route(Socket client, HashMap<String, String> optionalArguments)
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
