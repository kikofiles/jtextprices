package com.quimera.corptextiljt.model;

import static javax.persistence.GenerationType.IDENTITY;

// Generated Dec 23, 2017 11:54:35 AM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", catalog = "jtextpricesbd", uniqueConstraints = @UniqueConstraint(columnNames = "NickName"))
public class Usuario implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idusuario;
	private Tienda tienda;
	private String nickName;
	private String password;
	private String nombre;
	private Integer estatus;
	private Set<Precioproducto> precioproductosForUsuarioIdusuarioAlta = new HashSet<Precioproducto>(0);
	private Set<Precioproducto> precioproductosForUsuarioIdusuarioModifica = new HashSet<Precioproducto>(0);
	private Set<Acceso> accesos = new HashSet<Acceso>(0);
	private Set<Logprecioproducto> logprecioproductos = new HashSet<Logprecioproducto>(0);

	public Usuario() {
	}

	public Usuario(Tienda tienda, String nickName, String password, String nombre, Integer estatus) {
		this.tienda = tienda;
		this.nickName = nickName;
		this.password = password;
		this.nombre = nombre;
		this.estatus = estatus;
	}

	public Usuario(Tienda tienda, String nickName, String password, String nombre,
			Integer estatus, Set<Precioproducto> precioproductosForUsuarioIdusuarioAlta,
			Set<Precioproducto> precioproductosForUsuarioIdusuarioModifica, Set<Acceso> accesos,
			Set<Logprecioproducto> logprecioproductos) {
		this.tienda = tienda;
		this.nickName = nickName;
		this.password = password;
		this.nombre = nombre;
		this.estatus = estatus;
		this.precioproductosForUsuarioIdusuarioAlta = precioproductosForUsuarioIdusuarioAlta;
		this.precioproductosForUsuarioIdusuarioModifica = precioproductosForUsuarioIdusuarioModifica;
		this.accesos = accesos;
		this.logprecioproductos = logprecioproductos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "IDUsuario", unique = true, nullable = false)
	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}

	@Column(name = "NickName", unique = true, nullable = false, length = 20)
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "Password", nullable = false, length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Nombre", nullable = false, length = 40)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "Estatus", nullable = false)
	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioByUsuarioIdusuarioAlta")
	public Set<Precioproducto> getPrecioproductosForUsuarioIdusuarioAlta() {
		return this.precioproductosForUsuarioIdusuarioAlta;
	}

	public void setPrecioproductosForUsuarioIdusuarioAlta(
			Set<Precioproducto> precioproductosForUsuarioIdusuarioAlta) {
		this.precioproductosForUsuarioIdusuarioAlta = precioproductosForUsuarioIdusuarioAlta;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuarioByUsuarioIdusuarioModifica")
	public Set<Precioproducto> getPrecioproductosForUsuarioIdusuarioModifica() {
		return this.precioproductosForUsuarioIdusuarioModifica;
	}

	public void setPrecioproductosForUsuarioIdusuarioModifica(
			Set<Precioproducto> precioproductosForUsuarioIdusuarioModifica) {
		this.precioproductosForUsuarioIdusuarioModifica = precioproductosForUsuarioIdusuarioModifica;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Acceso> getAccesos() {
		return this.accesos;
	}

	public void setAccesos(Set<Acceso> accesos) {
		this.accesos = accesos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Logprecioproducto> getLogprecioproductos() {
		return this.logprecioproductos;
	}

	public void setLogprecioproductos(Set<Logprecioproducto> logprecioproductos) {
		this.logprecioproductos = logprecioproductos;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tienda_IDTienda", nullable = false)
	public Tienda getTienda() {
		return this.tienda;
	}
	
	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
}
