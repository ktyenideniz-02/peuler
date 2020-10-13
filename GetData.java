import java.io.IOException;
import java.io.FileWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GetData {
        public static void main(String[] args) throws IOException {
                String data = "";
                String title = "";
                String websiteURL = "";

                FileWriter fw = new FileWriter("data.txt");

                for(int i = 1; i < 717; i++){
                        websiteURL = "https://projecteuler.net/problem=" + Integer.valueOf(i);

                        try {
                                Document currentPage = Jsoup.connect(websiteURL).get();
                                title = currentPage.body().select("h2").text();
                                data = currentPage.body().select("div.problem_content").text();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }

                        fw.write(i + "- " + title + "\n");
                        fw.write(data);
                        fw.write("\n\n");

                        System.out.println(i + "/716 is done");
                }
                fw.close();
        }

}