package com.luv2code.hibernate.demo.entity;


import lombok.Data;
import lombok.NonNull;
import net.sf.ehcache.config.PersistenceConfiguration;

import javax.persistence.*;


@Data
@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NonNull
    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @NonNull
    @Column(name = "hobby")
    private String hobby;

    public InstructorDetail(){}

    public InstructorDetail(@NonNull String youtubeChannel, @NonNull String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    @OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Instructor instructor;

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
