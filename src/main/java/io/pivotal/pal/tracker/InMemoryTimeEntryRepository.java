package io.pivotal.pal.tracker;

import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

     long counter = 1L;
     HashMap<Long, TimeEntry> repository = new HashMap<>();
    
    public TimeEntry create(TimeEntry timeEntry) {
        long id = counter++;
        TimeEntry timeEntryObj = new TimeEntry(id, timeEntry.getProjectId(), timeEntry.getUserId(),
                timeEntry.getDate(), timeEntry.getHours());
        repository.put(id, timeEntryObj);
        return timeEntryObj;
    }

    @Override
    public TimeEntry find(long id) {
       return repository.get(id);
    }

    public List list() {
        return new ArrayList(repository.values());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        if(find(id)==null) return null;

        timeEntry.setId(id);
        repository.replace( id, timeEntry);
        return timeEntry;

    }

    public void delete(long id) {
        repository.remove(id);
    }
}
