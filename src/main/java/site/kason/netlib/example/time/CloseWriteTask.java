package site.kason.netlib.example.time;

import site.kason.netlib.io.IOBuffer;
import site.kason.netlib.tcp.Channel;
import site.kason.netlib.tcp.WriteTask;

/**
 *
 * @author Kason Yang
 */
public class CloseWriteTask implements WriteTask {

  @Override
  public boolean handleWrite(Channel channel, IOBuffer buffer) throws Exception {
    channel.close();
    return true;
  }

}
