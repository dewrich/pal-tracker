package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    public TimeEntry create(TimeEntry any);
    public TimeEntry find(long id);
    public TimeEntry update(long id, TimeEntry any);
    public List<TimeEntry> list();
    public void delete(long id);

}
