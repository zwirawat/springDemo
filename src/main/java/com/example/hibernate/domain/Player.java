package com.example.hibernate.domain;

import lombok.*;

import javax.persistence.*;

/*@Getter
@Setter*/

 @Data
/* @Data -> lib ของ lombok, automatically generated getter(), setter(), toString() */

/* @ToString */
/* @AllArgsConstructor สร้าง parameterize constructor */

/* @NoArgsConstructor ไม่ต้องการใช้ Constructor */

@Entity

/*
@Table(indexes = {})
indexes => ตัว fields ที่มีการถูกเรียกใช้บ่อยๆ เพิ่ม performance
ลดการ call ใหม่ ให้เก็บใน RAM แทน แต่เวลา call ครั้งแรกจะช้า จึงต้องเลือกแค่ fields ที่จำเป็น
*/
/* ต้องใช้ Column กับ ColumnList ชื่อเดียวกัน*/
@Table(indexes = {
        @Index(name = "name", columnList = "name"),
        @Index(name = "job", columnList = "job")
})

public class Player {
    @Id
    /* @Id -> Primary key */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /* @GeneratedValue -> generated auto_increment id */
    private Integer idPlayer;

    /* @Column(name="changeName", length="") ชื่อ columnName บน database */
    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "job", length = 30)
    private String job;
}
