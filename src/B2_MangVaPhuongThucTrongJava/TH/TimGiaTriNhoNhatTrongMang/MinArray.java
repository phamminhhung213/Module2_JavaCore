package B2_MangVaPhuongThucTrongJava.TH.TimGiaTriNhoNhatTrongMang;


public class MinArray {
    public static void main(String[] args) {
        int[] arr = {4, 1, 0, 8, 15, 0, 9};
        String index = minArray(arr);
        System.out.println(index);
        //System.out.println("phần tử nhỏ nhất là: " + arr[index] +"  Tại vị trí "+index);
//        int [] arr;
//        arr = new int[10];
//        Random kb = new Random();
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = kb.nextInt(20);
//            System.out.println(arr[i] + "\t");
//        }
//        int index = minArray(arr);
//        System.out.println("số nhỏ nhất trong mảng là "+arr[index] + "Tại vị trí thứ " +index);

    }

    public static String minArray(int[] array) {
        int min = array[0];
        String index = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == min) {
                index += "  index " +i+" value "+min;
            }
        }

        return index;

    }
}
