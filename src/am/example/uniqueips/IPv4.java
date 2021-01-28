package am.example.uniqueips;

import java.util.Arrays;

public final class IPv4 {

    private final byte[] arr;

    public IPv4(byte[] arr) {
        this.arr = arr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IPv4 iPv4 = (IPv4) o;
        return Arrays.equals(arr, iPv4.arr);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
    }
}
