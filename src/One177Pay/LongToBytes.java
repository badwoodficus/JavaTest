package One177Pay;
//將一個Long的值轉換成Byte[]
public class LongToBytes {
	public static void main(String[] args) {
		long value = 123456789L;
		byte[] bytes = LongToBytes(value);
		
		System.out.println("Long值: "+value);
		System.out.println("轉換後的byte[]: ");
		for(byte b : bytes) {
			System.out.print(b+" ");
		}
	}
	
	public static byte[] LongToBytes(Long value){
		byte[] result = new byte[8];
		for(int i=7; i>=0; i--) {
			result[i] = (byte)(value & 0xFF);
			value >>= 8;
		}
		return result;
	}
}
