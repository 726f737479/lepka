package com.dev.rosty.lepka.lib.logic;

import com.dev.rosty.lepka.lib.screen.Data;
import com.dev.rosty.lepka.lib.screen.DataEmpty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


final class DataHeap {

    private Map<String, List<DataEntry>> dataMap = new HashMap<>();

    Data getData(String moduleKey, String screenKey) {

        if (dataMap.containsKey(moduleKey)) {

            for (DataEntry entry : dataMap.get(moduleKey)) {

                if (entry.screenKey.equals(screenKey))
                    return entry.data;
            }
        }

        return new DataEmpty();
    }

    void addData(String moduleKey, String screenKey, Data data) {

        DataEntry entry = new DataEntry(screenKey, data);
        List<DataEntry> entries = new ArrayList<>();

        if (dataMap.containsKey(moduleKey)) {

            entries = dataMap.get(moduleKey);

            int index = entries.indexOf(entry);

            if (index > 0) entries.set(index, entry);

            else entries.add(entry);

        } else {

            entries.add(entry);
            dataMap.put(moduleKey, entries);
        }
    }

    void clearData(String moduleKey) {

        dataMap.remove(moduleKey);
    }

    private class DataEntry {

        private String screenKey;
        private Data   data;

        private DataEntry(String screenKey, Data data) {

            this.screenKey = screenKey;
            this.data      = data;
        }

        @Override public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DataEntry dataEntry = (DataEntry) o;

            return screenKey != null
                    ? screenKey.equals(dataEntry.screenKey)
                    : dataEntry.screenKey == null;
        }
    }
}
