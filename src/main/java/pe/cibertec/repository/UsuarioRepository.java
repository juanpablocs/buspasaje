package pe.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.cibertec.models.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsuario(String usuario);
}
