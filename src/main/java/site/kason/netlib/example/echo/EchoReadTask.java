package site.kason.netlib.example.echo;

import site.kason.netlib.io.IOBuffer;
import site.kason.netlib.tcp.Channel;
import site.kason.netlib.tcp.ReadTask;
import site.kason.netlib.tcp.tasks.ByteWriteTask;

/**
 *
 * @author Kason Yang
 */
public class EchoReadTask implements ReadTask {

  @Override
  public boolean handleRead(Channel channel, IOBuffer buffer) throws Exception {
    int readableSize = buffer.getReadableSize();
    byte[] data = new byte[readableSize];
    buffer.poll(data);
    channel.write(new ByteWriteTask(data));
    channel.prepareRead();
    return false;
  }

}
