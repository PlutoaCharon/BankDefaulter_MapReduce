package bankfinddefaulter;


import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class FindDefaulter {

    public static void main(String[] args) throws Throwable {
        // TODO Auto-generated method stub
        Job job = new Job();
        job.setJarByClass(FindDefaulter.class);

        FileInputFormat.addInputPath(job, new Path("hdfs://172.18.74.236:9000/input/UCI_Credit_Card.csv"));  // csv文件所在目录
        FileOutputFormat.setOutputPath(job, new Path("hdfs://172.18.74.236:9000/output"));                   // 设置输出文件目录

        // 关联自定义的mapper和reducer
        job.setMapperClass(BankMapper.class);
        job.setReducerClass(BankReducer.class);

        // 设置map输入数据类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        // 设置最终输出数据类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        System.exit(job.waitForCompletion(true)?0:1);
    }

}
