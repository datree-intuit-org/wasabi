package com.intuit.wasabi.assignment.countAggregation.impl;

import com.intuit.wasabi.assignmentobjects.Assignment;
import com.intuit.wasabi.experimentobjects.Experiment;
import com.intuit.wasabi.repository.AssignmentsRepository;
import com.intuit.wasabi.repository.ExperimentRepository;
import com.intuit.wasabi.repository.cassandra.impl.AssignmentStats;
import com.intuit.wasabi.repository.cassandra.impl.CassandraAssignmentsRepository;

import javax.inject.Inject;

import java.util.Date;


public class AssignmentsHourlyAggregatorTask implements Runnable {

    private AssignmentsRepository assignmentsRepository;
    private AssignmentStats assignmentStats;
    private CassandraAssignmentsRepository dbAssignmentsRepository;
    private ExperimentRepository cassandraExperimentRepository;
    private ExperimentRepository dbExperimentRepository;
    private Experiment experiment;
    private Assignment assignment;
    private boolean countUp;
    private Date date;
    private boolean assignUserToExport;
    private boolean assignBucketCount;
    private String day;
    private int eventTimeHour;

    @Inject
    public AssignmentsHourlyAggregatorTask(AssignmentStats assignmentStats){
        this.assignmentStats = assignmentStats;
    }

    @Override
    public void run() {

        assignmentStats.writeCounts(experiment, assignment);

        /*
        Date completedHour = getLastCompletedHour(System.currentTimeMillis());
        day = getDayString(completedHour);
        eventTimeHour = getHour(completedHour);
        startTime = getStartTime(completedHour);
        endTime = getEndTime(completedHour);

        // Set start and end time for the completed hour
        Calendar cStart = Calendar.getInstance();
        cStart.setTime(startTime);
        Calendar cEnd = Calendar.getInstance();
        cEnd.setTime(endTime);

        */

        // Write counts for even hour into cassandra


    }

    /*

    public static Date getStartTime(Date completedHour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(completedHour);
        int oldMinutes = cal.get(Calendar.MINUTE);
        int oldSeconds = cal.get(Calendar.SECOND);
        cal.add(Calendar.MINUTE, -oldMinutes);
        cal.add(Calendar.SECOND, -oldSeconds);
        return cal.getTime();
    }

    public static Date getEndTime(Date completedHour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(completedHour);
        int oldMinutes = cal.get(Calendar.MINUTE);
        int oldSeconds = cal.get(Calendar.SECOND);
        cal.add(Calendar.MINUTE, (59 - oldMinutes));
        cal.add(Calendar.SECOND, (60 - oldSeconds));
        return cal.getTime();
    }

    */


    // single thread to flush previous counts
    // current thread to update counts

    // shut down hook to prevent loss from shut down push counts to db

    /*
        Get the latest completed hour
        Correctly format day and eventTimeHour
        Set start time to first second of completed hour?
        Set end time to first second of the next hour?

        Use a map to get the assignment counts
        Can't create records for all the assignments or else I'm doing what I'm trying to prevent
        Constantly aggregate the data as it runs...

        For each experiment and bucket, write a new row into hourly bucket counts table w/ correct date, hour, exp,
            bucket, and count
        Create unit tests to make sure I'm using the correct experiments that are in the specified time range
    */

}

