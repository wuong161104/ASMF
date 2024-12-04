import java.util.TreeMap;
public class TreeMapExample {
    public static void main(String[] args) {
        // Tạo một TreeMap để lưu thông tin trái cây và giá của chúng
        TreeMap<String, Integer> fruitPrices = new TreeMap<>();

        // Thêm các cặp key-value vào TreeMap
        fruitPrices.put("Táo", 30000);
        fruitPrices.put("Chuối", 10000);
        fruitPrices.put("Cam", 20000);
        fruitPrices.put("Xoài", 40000);

        // Hiển thị các phần tử trong TreeMap (được sắp xếp theo key)
        System.out.println("Danh sách trái cây và giá:");
        for (String fruit : fruitPrices.keySet()) {
            System.out.println(fruit + ": " + fruitPrices.get(fruit) + " VND");
        }

        // Tìm giá của một loại trái cây cụ thể
        String searchFruit = "Cam";
        if (fruitPrices.containsKey(searchFruit)) {
            System.out.println("\nGiá của " + searchFruit + ": " + fruitPrices.get(searchFruit) + " VND");
        } else {
            System.out.println("\n" + searchFruit + " không có trong danh sách.");
        }

        // Xóa một phần tử
        fruitPrices.remove("Chuối");
        System.out.println("\nSau khi xóa Chuối:");
        System.out.println(fruitPrices);
    }
}
