import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Scanner;

/**
 * 命令行操作 读取 字符串分割 重新分组 输出
 */
public class chizaofan {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
        System.out.println(args[0]);//不使用上面的输入，直接采用args传值
//        System.out.println(read(("yq_in.txt")));
        FileOutputStream f = new FileOutputStream("yqo.txt");
        OutputStreamWriter writer = new OutputStreamWriter(f, "UTF-8");
        writer.append(read(args[0]));
        writer.close();
        f.close();
    }

    public static String read(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8));
//        BufferedReader br = new BufferedReader(new FileReader(filename));
        String file;
        String tmp = null;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while ((file = br.readLine()) != null) {
            String[] splited = file.split("\t");
            if (Objects.equals(splited[0], tmp)) {
                sb.append(splited[1]).append("\t").append(splited[2]).append("\n");
            } else {
                if (cnt == 0)
                    cnt++;
                else
                    sb.append("\n");//控制格式
                sb.append(splited[0]).append("\n");
                sb.append(splited[1]).append("\t").append(splited[2]).append("\n");
                tmp = splited[0];
            }
        }
        br.close();
        return sb.toString();
//        FileReader In_file = new FileReader("C:"+File.separator+"Users"+File.separator+"Administrator"+File.separator+"IdeaProject"+File.separator+"untitled"+File.separator+"src"+File.separator+file);
    }
}