package com.example.spring.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBatchExampleApplication {

    public static void main(String[] args) {

        System.out.println("Batch Execution Started");

        String[] springConfig = {"spring/batch/jobs/job-batch-demo.xml"};

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(springConfig);

        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("demoJobXmlWriter");

        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .addString("region", "CA")
                .addString("brand", "UQ")
                .toJobParameters();

        try {

            JobExecution execution = jobLauncher.run(job, jobParameters);
            System.out.println("Exit Status : " + execution.getStatus());

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Batch Execution Completed");
        context.close();

    }

}
