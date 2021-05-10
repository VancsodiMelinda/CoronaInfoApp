package com.example.coroninfo.test;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;

import com.example.coroninfo.src.data.AppDatabase;
import com.example.coroninfo.src.data.HistoryDao;
import com.example.coroninfo.src.data.HistoryEntity;
import com.example.coroninfo.src.data.TotalEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class HistoryDaoTest {
    private HistoryDao historyDao;
    private AppDatabase db = null;
    private static final String TAG = "HistoryDaoTest";

    @Before
    public void createDB()
    {
        Context context = ApplicationProvider.getApplicationContext();

        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).allowMainThreadQueries().build();
        historyDao = db.getHistoryDao();
    }

    @After
    public void closeDB()
    {
        db.close();
    }

    @Test
    public void insertHistoryDataTest()
    {
        // create data to insert
        String date = "2021-05-06";
        HistoryEntity testData = new HistoryEntity(7, date, "confirmed", 123);

        // insert data to db
        historyDao.insertHistoryData(testData);

        // load data from db
        HistoryEntity resultData = historyDao.loadHistoryDataByDate(date);

        // check
        boolean finalResult = isEqual(testData, resultData);

        // assert
        assertTrue(finalResult);
    }


    @Test
    public void loadAllHistoryDataTest()
    {
        // create data to insert
        HistoryEntity testData1 = new HistoryEntity(7, "2021-01-10", "confirmed", 123);
        HistoryEntity testData2 = new HistoryEntity(12, "2013-08-22", "recovered", 456);
        HistoryEntity[] testData = {testData1, testData2};

        // insert data to db
        historyDao.insertHistoryData(testData1);
        historyDao.insertHistoryData(testData2);

        // load data from db
        HistoryEntity[] resultData = historyDao.loadAllHistoryData();

        // check
        boolean finalResult = isEqualArray(testData, resultData);

        // assert
        assertTrue(finalResult);
    }

    private boolean isEqual(HistoryEntity a, HistoryEntity b)
    {
        boolean result = false;

        boolean cond0 = a.id == b.id;
        boolean cond1 = a.date.equals(b.date);
        boolean cond2 = a.status.equals(b.status);
        boolean cond3 = a.caseNumber == b.caseNumber;

        if (cond0 && cond1 && cond2 && cond3)
            result = true;

        return result;
    }

    private boolean isEqualArray(HistoryEntity[] a, HistoryEntity[] b)
    {
        boolean result = true;

        for (int i = 0; i < a.length; i++)
        {
            if (!isEqual(a[i], b[i]))
            {
                result = false;
                break;
            }
        }

        return result;
    }
}
