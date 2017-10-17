package site.kason.netlib.example.echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import site.kason.netlib.tcp.AcceptHandler;
import site.kason.netlib.tcp.Channel;
import site.kason.netlib.tcp.ChannelHost;

/**
 *
 * @author Kason Yang
 */
public class EchoServer {
  
  public static void main(String[] args) throws IOException {
    int port = 7;
    String hostname = "localhost";
    ChannelHost channelHost = ChannelHost.create();
    channelHost.createServerChannel(new InetSocketAddress(hostname,port), new AcceptHandler() {
      @Override
      public void accepted(Channel channel) {
        channel.read(new EchoReadTask());
      }
    });
    System.out.format("Echo Server running at %s:%d",hostname,port);
    channelHost.listen();
  }

}
