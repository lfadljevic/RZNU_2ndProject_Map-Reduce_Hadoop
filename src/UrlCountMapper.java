import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class UrlCountMapper extends MapReduceBase 
	implements Mapper<LongWritable, Text, Text, Text> {
	
	public void map(LongWritable key, Text value,
			OutputCollector<Text, Text> output, Reporter reporter) throws IOException {

		String[] parts = (value.toString()).split(" ");
		String route = parts[0];
		String browser = parts[1];

		output.collect(new Text(route), new Text(browser));
	}
}