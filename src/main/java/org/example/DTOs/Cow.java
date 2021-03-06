package org.example.DTOs;

import java.time.LocalDate;
import java.util.Objects;

// localDate format year : month : day
public class Cow {
    private int tag_id;
    private String sex;
    private String breed;
    private LocalDate dateOfBirth;
    private int milkYields;

    public Cow(int tag_id, String sex, String breed, int year, int month, int day, int milkYields)
    {
        this.tag_id = tag_id;
        this.sex = sex;
        this.breed = breed;
        this.dateOfBirth = LocalDate.of(year, month, day);
        this.milkYields = milkYields;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getMilkYields(){return milkYields;}

    public void setMilkYields(int milkYields){this.milkYields = milkYields;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cow cow = (Cow) o;
        return tag_id == cow.tag_id && milkYields == cow.milkYields && Objects.equals(sex, cow.sex) && Objects.equals(breed, cow.breed) && Objects.equals(dateOfBirth, cow.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag_id, sex, breed, dateOfBirth, milkYields);
    }

    @Override
    public String toString() {
        return "Cow{" +
                "tag_id=" + tag_id +
                ", sex='" + sex + '\'' +
                ", breed='" + breed + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", milkYields=" + milkYields +
                '}';
    }

}
