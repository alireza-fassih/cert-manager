package ir.fassih.homework.certmanager.entity

import javax.persistence.*


@Table(name = "CERT_USER")
@Entity
class UserEntity(

    @Column(name="USERNAME")
    var username: String,

    @Column(name="PASSWORD")
    var password: String,

    @Id @GeneratedValue
    @Column(name = "ID")
    var id: Long? = null

)