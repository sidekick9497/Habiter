package com.sidekick.apps.habiter.models;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by HaRRy on 7/19/2018.
 */
@Database(entities = {Habit.class,User.class,UnsuccessfulHabit.class,Rewards.class},version = 5,exportSchema =
        false)
public abstract class HabitsDatabase extends RoomDatabase {
    private static final String DB_NAME = "HABITER";
    private static HabitsDatabase habitsDatabase;
    public static HabitsDatabase getDatabase(Context context)
    {
        if(habitsDatabase == null)
        {
            habitsDatabase = Room.databaseBuilder(context.getApplicationContext(),HabitsDatabase.class,DB_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();

        }
        return habitsDatabase;
    }
    public  abstract HabitsDao habitsDao();
    public abstract UserDao userDao();
    public abstract UnsuccessfulHabitsDao unsuccessfulHabitsDao();
    public abstract RewardsDao rewardsDao();


}
