package party.shaytang.search.controllers.entities;

import java.util.List;

public class SearchArticleRequest {
    private int page;

    private int size;

    private String key;

    private String major;

    private String degree;

    private List<GradeParam> gradeParams;

    public SearchArticleRequest() {
    }

    public SearchArticleRequest(int page, int size, String key, String major, String degree,
                                List<GradeParam> gradeParams) {
        this.page = page;
        this.size = size;
        this.key = key;
        this.major = major;
        this.degree = degree;
        this.gradeParams = gradeParams;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public List<GradeParam> getGradeParams() {
        return gradeParams;
    }

    public void setGradeParams(List<GradeParam> gradeParams) {
        this.gradeParams = gradeParams;
    }

    public static class GradeParam {
        private String type;

        private float minScore;

        private float maxScore;

        public GradeParam() {
        }

        public GradeParam(String type, float minScore, float maxScore) {
            this.type = type;
            this.minScore = minScore;
            this.maxScore = maxScore;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public float getMinScore() {
            return minScore;
        }

        public void setMinScore(float minScore) {
            this.minScore = minScore;
        }

        public float getMaxScore() {
            return maxScore;
        }

        public void setMaxScore(float maxScore) {
            this.maxScore = maxScore;
        }
    }
}
