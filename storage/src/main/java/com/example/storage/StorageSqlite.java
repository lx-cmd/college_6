package com.example.storage;

public class StorageSqlite implements IStorage {
    @Override
    public <T> boolean save(String key, T value) {
        return false;
    }

    @Override
    public <T> T get(String key) {
        return null;
    }
}
