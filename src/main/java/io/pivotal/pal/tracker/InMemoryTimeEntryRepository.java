package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private final Map<Long, TimeEntry> repository = new HashMap<Long, TimeEntry>();;
    private long sequenceId;

    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry updatedTimeEntry = new TimeEntry(getNextSequenceId(), timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
        repository.put(updatedTimeEntry.getId(), updatedTimeEntry);
        return updatedTimeEntry;
    }

    public TimeEntry find(long id) {
        return repository.get(id);
    }

    public List<TimeEntry> list() {
        return repository.values().stream().collect(Collectors.toList());

    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        if (repository.size() >0)
        {
            TimeEntry updatedTimeEntry = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(), timeEntry.getDate(), timeEntry.getHours());
            repository.put(id, updatedTimeEntry);
            return updatedTimeEntry;
        }
        return null;
    }

    private long getNextSequenceId(){
        sequenceId++;
        return sequenceId;
    }

    public void delete(long id) {
        repository.remove(id);
    }
}
