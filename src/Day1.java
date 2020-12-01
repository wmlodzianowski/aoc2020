import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static java.nio.file.Files.lines;

public class Day1 {
        public static void main(String[] args) {
                Path path= Paths.get("day1input");
                //part 1
                try {
                        Set<Integer> parsed = new HashSet<>();
                        lines(path).forEach( a->{
                                Integer number = Integer.parseInt(a);
                                int lookingFor = 2020-number;
                                if (parsed.contains(lookingFor)){
                                        System.out.println(number * (lookingFor));
                                }else{
                                        parsed.add(number);
                                }
                                }

                        );
                } catch (IOException ex) {
                        ex.printStackTrace();
                }
                //part 2

                try {
                        ArrayList<Integer> entries=new ArrayList<>();
                        lines(path).forEach( a->{
                                        entries.add(Integer.parseInt(a));
                                }

                        );

                        Collections.sort(entries);

                        for (int i=0;i<entries.size();i++){
                                int first=entries.get(i);
                                HashSet<Integer> parsed2 = new HashSet<>();
                                for (int j=i+1;j<entries.size();j++){
                                        int second=entries.get(j);
                                        int third=2020-(first+second);

                                        if(parsed2.contains(third)){
                                                System.out.println("Found!!");
                                                System.out.println(first*second*third);
                                        }else {
                                                parsed2.add(second);
                                        }
                                }
                        }

                } catch (IOException ex) {
                        ex.printStackTrace();
                }

        }
}
