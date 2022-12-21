package ua.goit.hibernate.model.dao;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "skills")
public class SkillDao {
    Integer id;
    String programmingLanguage;
    String skillLevel;
    Set<DeveloperDao> developers;

    public SkillDao() {
    }

    public SkillDao(Integer id, String programmingLanguage, String skillLevel) {
        this.id = id;
        this.programmingLanguage = programmingLanguage;
        this.skillLevel = skillLevel;
    }

    public SkillDao(String programmingLanguage, String skillLevel) {
        this.programmingLanguage = programmingLanguage;
        this.skillLevel = skillLevel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_skill")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "programming_language", length = 45)
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Column(name = "skill_level", length = 45)
    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    @ManyToMany(mappedBy = "skills")
    public Set<DeveloperDao> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set<DeveloperDao> developers) {
        this.developers = developers;
    }
}
