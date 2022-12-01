package ua.goit.hibernate.model.dto;

import java.util.Objects;

public class SkillDto {
    private Integer id;
    private String programmingLanguage;
    private String skillLevel;

    public SkillDto(Integer id, String programmingLanguage, String skillLevel) {
        this.id = id;
        this.programmingLanguage = programmingLanguage;
        this.skillLevel = skillLevel;
    }

    public SkillDto(String programmingLanguage, String skillLevel) {
        this.programmingLanguage = programmingLanguage;
        this.skillLevel = skillLevel;
    }

    public SkillDto(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillDto skillDto = (SkillDto) o;
        return Objects.equals(id, skillDto.id) && Objects.equals(programmingLanguage, skillDto.programmingLanguage) && Objects.equals(skillLevel, skillDto.skillLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, programmingLanguage, skillLevel);
    }
}
