package site.kason.netlib.example.time;

import java.io.IOException;
import java.net.InetSocketAddress;
import site.kason.netlib.tcp.AcceptHandler;
import site.kason.netlib.tcp.Channel;
import site.kason.netlib.tcp.ChannelHost;

/**
 *
 * @author Kason Yang
 */
public class TimeServer {
  
  public static void main(String[] args) throws IOException {
    int port = 37;
    String hostname = "0.0.0.0";
    ChannelHost channelHost = ChannelHost.create();
    channelHost.createServerChannel(new InetSocketAddress(hostname,port), new AcceptHandler() {
      @Override
      public void accepted(Channel channel) {
        channel.write(new TimeWriteTask());
        channel.write(new CloseWriteTask());
      }
    });
    System.out.format("Time Server running at %s:%d",hostname,port);
    channelHost.listen();
  }

}
