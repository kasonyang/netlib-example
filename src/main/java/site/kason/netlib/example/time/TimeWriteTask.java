package site.kason.netlib.example.time;

import kamons.binary.BinaryUtil;
import site.kason.netlib.tcp.tasks.ByteWriteTask;

/**
 *
 * @author Kason Yang
 */
public class TimeWriteTask extends ByteWriteTask {

  public TimeWriteTask() {
    super(createTimeData());
  }

  private static byte[] createTimeData() {
    long time = System.currentTimeMillis() / 1000L + 2208988800L;
    byte[] array = new byte[4];
    BinaryUtil.writeInt(array, 0, (int) time);
    return array;
  }

}
