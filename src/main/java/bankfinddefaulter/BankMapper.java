package bankfinddefaulter;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import au.com.bytecode.opencsv.CSVParser;

public class BankMapper extends
        Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        if (key.get() > 0) {

            String[] lines = new CSVParser().parseLine(value.toString());

            //选取csv文件中第25行数据进行统计
            context.write(new Text(lines[24]), new IntWritable(1));

        }
    }
}
