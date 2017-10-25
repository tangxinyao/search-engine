package party.shaytang.search.repositories.entites;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

public class Grade {
    @Field(type = FieldType.Float)
    private float toefl;
    @Field(type = FieldType.Float)
    private float ielts;
    @Field(type = FieldType.Float)
    private float gpa;
    @Field(type = FieldType.Float)
    private float sat;
    @Field(type = FieldType.Float)
    private float act;
    @Field(type = FieldType.Float)
    private float rank;

    public Grade() {
    }

    public float getToefl() {
        return toefl;
    }

    public void setToefl(float toefl) {
        this.toefl = toefl;
    }

    public float getIelts() {
        return ielts;
    }

    public void setIelts(float ielts) {
        this.ielts = ielts;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public float getSat() {
        return sat;
    }

    public void setSat(float sat) {
        this.sat = sat;
    }

    public float getAct() {
        return act;
    }

    public void setAct(float act) {
        this.act = act;
    }

    public float getRank() {
        return rank;
    }

    public void setRank(float rank) {
        this.rank = rank;
    }
}
