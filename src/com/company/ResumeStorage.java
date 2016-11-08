package com.company;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Anton on 03.11.2016.
 */
public class ResumeStorage implements Storage {
    final int storageMaxLength = 3;
    Resume[] storage = new Resume[storageMaxLength];
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String variable;
    private int size = 0;


    @Override
    public void save(Resume uuid) throws IOException {

        for (int i = 0; i < size+1; i++) {
            if (size == storageMaxLength) {
                System.out.println("The memory is full");
                break;
            }
//
            if (storage[i]  == null) {
                System.out.println("Create a new resume...");
                Resume resume = new Resume(reader.readLine());
                storage[i] = resume;
                System.out.println("Resume successfully saved: " + storage[i].toString());
                System.out.println();
                size++;
                break;
            }
            //for (int j = 0; j < size; j++) {
                if (storage[i].getUuid().equals(uuid.getUuid())) {
                    System.out.println("Resumes are the same!");
                    return;
                }
            //}
        }
    }

    @Override
    public void delete(String uuid) throws IOException {
        System.out.println("Select a resume for deleting:");
        resumes();
        variable = reader.readLine();
        try {
            for (int i = 0; i < storageMaxLength; i++) {
                String s = storage[i].toString();
                if (s.equals(variable)) {
                    storage[i] = null;
                    System.out.println("Resume " + s.toString() + " deleted!");
                    System.out.println();
                    break;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Resume does not exist! Choose a resume...");
            delete(uuid);
        }

    }

    @Override
    public Resume get(String uuid) throws IOException {
        System.out.println("Select resume for reading");
        resumes();
        variable = reader.readLine();
        try {
            for (int i = 0; i < storageMaxLength; i++) {
                String s = storage[i].toString();
                if (s.equals(variable)) {
                    System.out.println("Resume selected " + storage[i].toString());
                    System.out.println();
                    break;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Resume does not exist! Choose a resume...");
            return get(uuid);
        }
//        return new Resume(uuid);
        return new Resume(uuid);
    }

    @Override
    public void update(Resume r) throws IOException {
        System.out.println("Select a resume for updating:");
        resumes();
        variable = reader.readLine();
        try {
            for (int i = 0; i < storageMaxLength; i++) {
                String s = storage[i].toString();
                if (s.equals(variable)) {
                    System.out.println("Resume " + storage[i].toString() + " is ready for updating...");
                    Resume resume = new Resume(reader.readLine());
                    storage[i] = resume;
                    System.out.println("Resume successfully updated " + storage[i].toString());
                    System.out.println();
                    break;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Resume does not exist! Choose a resume...");
            update(r);
        }
    }

    private void resumes() {
        for (int i = 0; i < storageMaxLength; i++) {
            if (storage[i] != null) {
                System.out.println(storage[i].toString());
            }
        }
    }
}
