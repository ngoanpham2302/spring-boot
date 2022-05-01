package vn.techmaster.labdidemo.bean;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class StreetMap {
    private static final String[] FROMS = {"48 Tố Hữu, Nam Từ Liêm", "15 Đoàn Trần Nghiệp, Hai Bà Trưng",
            "79 Mai Hắc Đế, Hai Bà Trưng", "2 Hàng Bạc, Hoàn Kiếm"};
    private static final String[] TOS = {"Hồ Đồng Đò", "Sân Gold Tam Đảo", "Royal City", "Sân bay Nội Bài"};

    private String route;
    private SecureRandom rand;

    public StreetMap() {
        try {
            // Khởi tạo bộ sinh số ngẫu nhiên
            rand = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        // Tạo ra tuyến ngẫu nhiên từ điểm A thuộc mảng FROMS, đến điểm B thuộc mảng TOS
        this.route = "From: <b>" + getRandomFromArrayString(FROMS) + "</b> → To: <b>"
                + getRandomFromArrayString(TOS) + "</b>";
    }

    public String getRoute() {
        return route;
    }

    // Hàm generic lấy ngẫu nhiên 1 phần tử trong mảng truyền vào
    private <T> T getRandomFromArrayString(T[] array) {
        int index = this.rand.nextInt(array.length);
        return array[index];
    }
}