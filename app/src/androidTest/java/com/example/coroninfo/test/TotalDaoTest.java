package com.example.coroninfo.test;

import android.content.Context;
import android.util.Log;

import androidx.room.PrimaryKey;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SmallTest;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.coroninfo.mock.TestDatabase;
import com.example.coroninfo.src.data.AppDatabase;
import com.example.coroninfo.src.data.TotalDao;
import com.example.coroninfo.src.data.TotalEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class TotalDaoTest {
    private TotalDao totalDao;
    private AppDatabase db = null;
    private static final String TAG = "TotalDaoTest";

    @Before
    public void createDB()
    {
        Log.d(TAG, "createDB");
        Context context = ApplicationProvider.getApplicationContext();

        if (context == null)
            Log.d(TAG, "context is null");

        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).allowMainThreadQueries().build();
        totalDao = db.getTotalDao();
    }

    @After
    public void closeDB()
    {
        Log.d(TAG, "closeDB");
        db.close();
    }

    @Test
    public void insertTotalDataTest()
    {
        Log.d(TAG, "insertTotalDataTest");

        // create data to insert
        String country = "Hungary";
        TotalEntity testData = new TotalEntity(12, country, 123, 456, 789);

        // insert data to db
        totalDao.insertTotalData(testData);

        // load data from db
        TotalEntity resultData = totalDao.loadTotalDataByCountry(country);

        // check
        boolean finalResult = isEqual(testData, resultData);

        // assert
        assertTrue(finalResult);
    }

    @Test
    public void loadAllTotalDataTest()
    {
        // create data to insert
        TotalEntity testData1 = new TotalEntity(1, "Hungary", 123, 456, 789);
        TotalEntity testData2 = new TotalEntity(2, "Canada", 1230, 4560, 7890);
        TotalEntity[] testData = {testData1, testData2};

        // insert data to db
        totalDao.insertTotalData(testData1);
        totalDao.insertTotalData(testData2);

        // load data from db
        TotalEntity[] resultData = totalDao.loadAllTotalData();

        // check
        boolean finalResult = isEqualArray(testData, resultData);

        // assert
        assertTrue(finalResult);
    }

    private boolean isEqual(TotalEntity a, TotalEntity b)
    {
        boolean result = false;

        boolean cond0 = a.id == b.id;
        boolean cond1 = a.country.equals(b.country);
        boolean cond2 = a.totalConfirmed == b.totalConfirmed;
        boolean cond3 = a.totalRecovered == b.totalRecovered;
        boolean cond4 = a.totalDeath == b.totalDeath;

        if (cond0 && cond1 && cond2 && cond3 && cond4)
            result = true;

        return result;
    }

    private boolean isEqualArray(TotalEntity[] a, TotalEntity[] b)
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
