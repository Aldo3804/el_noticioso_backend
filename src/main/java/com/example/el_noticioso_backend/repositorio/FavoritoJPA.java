package com.example.el_noticioso_backend.repositorio;

import com.example.el_noticioso_backend.dto.FavoritoDTO;
import com.example.el_noticioso_backend.dto.NoticiaDTO;
import com.example.el_noticioso_backend.entidades.Favorito;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritoJPA extends JpaRepository<Favorito,Integer> {

    @Query("""
    SELECT new com.example.el_noticioso_backend.dto.NoticiaDTO(
        n.idNoticia, n.titulo, n.resumen, n.fechaPublicacion,
        n.imagenUrl, n.autor,n.localia, n.etiqueta.idEtiqueta
    )
    FROM Noticia n
    JOIN Favorito f ON f.noticia.idNoticia = n.idNoticia
    WHERE f.usuario.idUsuario = :idUsuario
""")
    List<NoticiaDTO> listarNoticias(@Param("idUsuario") Integer idUsuario);

    @Query("SELECT COUNT(f) > 0 FROM Favorito f WHERE f.usuario.idUsuario = :idUsuario AND f.noticia.idNoticia = :idNoticia")
    boolean existeFavorito(@Param("idUsuario") Integer idUsuario, @Param("idNoticia") Integer idNoticia);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO favorito (id_usuario,id_noticia) VALUES (:idUsuario, :idNoticia)", nativeQuery = true)
    void aniadirFavorito(@Param("idUsuario") Integer idUsuario, @Param("idNoticia") Integer idNoticia);

    @Modifying
    @Transactional
    @Query(value = "delete from favorito where id_usuario=:idUsuario and id_noticia = :idNoticia",nativeQuery = true)
    void eliminarFavorito(@Param("idUsuario") Integer idUsuario,@Param("idNoticia") Integer idNoticia);

}
