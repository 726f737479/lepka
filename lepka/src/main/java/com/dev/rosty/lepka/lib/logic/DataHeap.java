package com.dev.rosty.lepka.lib.logic;

import com.dev.rosty.lepka.lib.screen.Data;
import com.dev.rosty.lepka.lib.screen.DataEmpty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rosty on 11/25/17.
 */

class DataHeap {

    private Map<String, List<DataEntry>> dataMap = new HashMap<>();

    Data getData(String routerKey, String screenKey) {

        if (dataMap.containsKey(routerKey)) {

            for (DataEntry entry : dataMap.get(routerKey)) {

                if (entry.screenKey.equals(screenKey))
                    return entry.data;
            }
        }

        return new DataEmpty();
    }

    void addData(String routerKey, String screenKey, Data data) {

        DataEntry entry = new DataEntry(screenKey, data);
        List<DataEntry> entries = new ArrayList<>();

        if (dataMap.containsKey(routerKey)) {

            entries = dataMap.get(routerKey);

            int index = entries.indexOf(entry);

            if (index > 0) entries.set(index, entry);

            else entries.add(entry);

        } else {

            entries.add(entry);
            dataMap.put(routerKey, entries);
        }
    }

    void clearData(String routerKey) {

        dataMap.remove(routerKey);
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
