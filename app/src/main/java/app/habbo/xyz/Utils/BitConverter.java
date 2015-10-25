package app.habbo.xyz.Utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class BitConverter {

    private static ByteBuffer _intShifter = ByteBuffer.allocate(Integer.SIZE / Byte.SIZE)
                .order(ByteOrder.LITTLE_ENDIAN);
    public static byte[] getBytes(int value) {
        _intShifter.clear();
        _intShifter.putInt(value);
        return _intShifter.array();
    }

    public static int getInt(byte[] data)
    {
        _intShifter.clear();
        _intShifter.put(data, 0, Integer.SIZE / Byte.SIZE);
        _intShifter.flip();
        return _intShifter.getInt();
    }
}
