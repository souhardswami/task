import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Area {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("input.json");
        byte[] buffer = new byte[10];
        StringBuilder sb = new StringBuilder();
        while (fis.read(buffer) != -1) {
            sb.append(new String(buffer));
            buffer = new byte[10];
        }
        fis.close();

        String content = sb.toString();
        Map<String, Figure> response = new ObjectMapper().readValue(content, new TypeReference<Map<String, Figure>>() {});
        Map<String,String> output = new HashMap<>();
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            Figure val = response.get(""+i);
            if (val == null) {
                break;
            }
            double area;
            if (val.type.equals("circle")) {
                area = round(22.0* val.radius *val.radius /7.0,2);
                output.put(""+i,""+area);
            } else if (val.type.equals("rectangle")) {
                output.put(""+i,""+(val.l*val.b));
            } else {
                output.put(""+i,""+(val.side * val.side));
            }

        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(Paths.get("output.json").toFile(), output);
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
