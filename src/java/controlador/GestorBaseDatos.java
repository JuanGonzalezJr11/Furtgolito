package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.*;

public class GestorBaseDatos {
    private Connection con;
    private final String CONN = "jdbc:sqlserver://DESKTOP-8CM8F2H:1433;databaseName=BD_Furtgolito;";
    private final String USER = "Furtgolito";
    private final String PASS = "1234";
    
    private void abrirConexion(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            con = DriverManager.getConnection(CONN, USER, PASS);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void cerrarConexion(){
        try{
            if(con != null && !con.isClosed()){
                con.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    // ----------------------------- USUARIO ----------------------------------
    
    public void altaUsuario(Usuario u){
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Usuarios VALUES (?, ?)");
            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getContrasena());
            
            ps.executeUpdate();
            ps.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
    }
    
    public boolean modificarUsuario(Usuario usuario){
        boolean resultado = false;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Usuarios SET usuario = ?, contrasena = ? WHERE idUsuario = ?");
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getContrasena());
            ps.setInt(3, usuario.getIdUsuario());
            ps.executeUpdate();
            resultado = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return resultado;
    }
    
    public void eliminarUsuario(int idUsuario){
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("DELETE FROM Usuarios WHERE idUsuario = ?");
            ps.setInt(1, idUsuario);
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
    }
    
    public Usuario obtenerUsuarioPorId(int idUsuario){
        Usuario u = null;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Usuarios WHERE idUsuario = ?");
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String usuario = rs.getString("usuario");
                String contrasena = rs.getString("contrasena");
                u = new Usuario(idUsuario, usuario, contrasena);
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return u;
    }
    
    public ArrayList<Usuario> getListadoUsuarios(){
        ArrayList<Usuario> lista = new ArrayList<>();
        try{
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Usuarios");
            while(rs.next()){
                int idUsuario = rs.getInt("idUsuario");
                String usuario = rs.getString("usuario");
                String contrasena = rs.getString("contrasena");
                lista.add(new Usuario(idUsuario, usuario, contrasena));
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return lista;
    }
    
    // ---------------------------- JUGADOR ------------------------------------
    
    public void altaJugador(Jugador j){
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Jugadores VALUES (?, ?, ?, ?, ?, ?, 'false', ?, ?, ?)");
            ps.setString(1, j.getNombre());
            ps.setString(2, j.getApellido());
            ps.setInt(3, j.getEdad());
            ps.setInt(4, j.getPosicionJugador().getIdPosicionJugador());
            ps.setInt(5, j.getDorsal());
            ps.setInt(6, j.getEquipo().getIdEquipo());
            ps.setBoolean(7, j.isCapitan());
            ps.setString(8, j.getTelefono());
            ps.setString(9, j.getEmail());
            
            ps.executeUpdate();
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
    }
    
    public ArrayList<PosicionJugador> getPosicionesJugadores(){
        ArrayList<PosicionJugador> posiciones = new ArrayList<>();
        try{
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PosicionesJugadores");
            while(rs.next()){
                int idPosicionJugador = rs.getInt("idPosicionJugador");
                String posicionJugador = rs.getString("posicionJugador");
                posiciones.add(new PosicionJugador(idPosicionJugador, posicionJugador));
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return posiciones;
    }
    
    public ArrayList<Equipo> getEquipos(){
        ArrayList<Equipo> equipos = new ArrayList<>();
        try{
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Equipos");
            while(rs.next()){
                int idEquipo = rs.getInt("idEquipo");
                String nombre = rs.getString("nombre");
                equipos.add(new Equipo(idEquipo, nombre));
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return equipos;
    }
    
    public PosicionJugador obtenerPosicionJugador(int idPosicionJugador){
        PosicionJugador pj = null;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM PosicionesJugadores WHERE idPosicionJugador = ?");
            ps.setInt(1, idPosicionJugador);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String posicionJugador = rs.getString("posicionJugador");
                pj = new PosicionJugador(idPosicionJugador, posicionJugador);
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return pj;
    }
    
    public Equipo obtenerEquipo(int idEquipo){
        Equipo eq = null;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Equipos WHERE idEquipo = ?");
            ps.setInt(1, idEquipo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String nombre = rs.getString("nombre");
                eq = new Equipo(idEquipo, nombre);
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return eq;
    }
    
    public ArrayList<Jugador> getListadoJugadores(){
        ArrayList<Jugador> lista = new ArrayList<>();
        try{
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Jugadores\n" +
                                           "ORDER BY idPosicionJugador");
            while(rs.next()){
                int idJugador = rs.getInt("idJugador");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                int idPosicionJugador = rs.getInt("idPosicionJugador");
                PosicionJugador posicionJugador = obtenerPosicionJugador(idPosicionJugador);
                int dorsal = rs.getInt("dorsal");
                int idEquipo = rs.getInt("idEquipo");
                Equipo equipo = obtenerEquipo(idEquipo);
                boolean suspension = rs.getBoolean("suspension");
                boolean capitan = rs.getBoolean("capitan");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                
                lista.add(new Jugador(idJugador, nombre, apellido, edad, posicionJugador, dorsal, equipo, suspension, capitan, telefono, email));
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return lista;
    }
    
    public boolean modificarJugador(Jugador jugador){
        boolean resultado = false;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Jugadores SET nombre = ?, apellido = ?, edad = ?, idPosicionJugador = ?, dorsal = ?, idEquipo = ?, suspension = 'false', capitan = ?, telefono = ?, email = ? WHERE idJugador = ?");
            ps.setString(1, jugador.getNombre());
            ps.setString(2, jugador.getApellido());
            ps.setInt(3, jugador.getEdad());
            ps.setInt(4, jugador.getPosicionJugador().getIdPosicionJugador());
            ps.setInt(5, jugador.getDorsal());
            ps.setInt(6, jugador.getEquipo().getIdEquipo());
            ps.setBoolean(7, jugador.isCapitan());
            ps.setString(8, jugador.getTelefono());
            ps.setString(9, jugador.getEmail());
            ps.setInt(10, jugador.getIdJugador());
            
            ps.executeUpdate();
            resultado = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return resultado;
    }
    
    public Jugador obtenerJugadorPorId(int idJugador){
        Jugador j = null;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Jugadores WHERE idJugador = ?");
            ps.setInt(1, idJugador);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                int idPosicionJugador = rs.getInt("idPosicionJugador");
                PosicionJugador posicionJugador = obtenerPosicionJugador(idPosicionJugador);
                int dorsal = rs.getInt("dorsal");
                int idEquipo = rs.getInt("idEquipo");
                Equipo equipo = obtenerEquipo(idEquipo);
                boolean suspension = rs.getBoolean("suspension");
                boolean capitan = rs.getBoolean("capitan");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                
                j = new Jugador(idJugador, nombre, apellido, edad, posicionJugador, dorsal, equipo, suspension, capitan, telefono, email);
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return j;
    }
    
    public void jugadorSuspendido(int idJugador, int opcion){
        String sql = "";
        try{
            abrirConexion();
            if(opcion == 1){
                sql = "UPDATE Jugadores SET suspension = 'false' WHERE idJugador = ?";
            }
            else{
                sql = "UPDATE Jugadores SET suspension = 'true' WHERE idJugador = ?";
            }
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idJugador);
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
    }
    
    // ----------------------------- ARBITRO -----------------------------------
    
    public void altaArbitro(Arbitro a){
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Arbitros VALUES (?, ?, ?, ?)");
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellido());
            ps.setString(3, a.getTelefono());
            ps.setString(4, a.getEmail());
            
            ps.executeUpdate();
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
    }
    
    public ArrayList<Arbitro> getListadoArbitros(){
        ArrayList<Arbitro> lista = new ArrayList<>();
        try{
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Arbitros");
            while(rs.next()){
                int idArbitro = rs.getInt("idArbitro");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                
                lista.add(new Arbitro(idArbitro, nombre, apellido, telefono, email));
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return lista;
    }
    
    public boolean modificarArbitro(Arbitro arbitro){
        boolean resultado = false;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Arbitros SET nombre = ?, apellido = ?, telefono = ?, email = ? WHERE idArbitro = ?");
            ps.setString(1, arbitro.getNombre());
            ps.setString(2, arbitro.getApellido());
            ps.setString(3, arbitro.getTelefono());
            ps.setString(4, arbitro.getEmail());
            ps.setInt(5, arbitro.getIdArbitro());
            
            ps.executeUpdate();
            resultado = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return resultado;
    }
    
    public Arbitro obtenerArbitroPorId(int idArbitro){
        Arbitro a = null;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Arbitros WHERE idArbitro = ?");
            ps.setInt(1, idArbitro);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                
                a = new Arbitro(idArbitro, nombre, apellido, telefono, email);
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return a;
    }
    
    // ----------------------------- EQUIPO ------------------------------------
    
    public void altaEquipo(Equipo eq){
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Equipos VALUES (?)");
            ps.setString(1, eq.getNombre());
            
            ps.executeUpdate();
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
    }
    
    public ArrayList<Equipo> getListadoEquipos(){
        ArrayList<Equipo> lista = new ArrayList<>();
        try{
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Equipos");
            while(rs.next()){
                int idEquipo = rs.getInt("idEquipo");
                String nombre = rs.getString("nombre");
                
                lista.add(new Equipo(idEquipo, nombre));
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return lista;
    }
    
    public boolean modificarEquipo(Equipo equipo){
        boolean resultado = false;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Equipos SET nombre = ? WHERE idEquipo = ?");
            ps.setString(1, equipo.getNombre());
            ps.setInt(2, equipo.getIdEquipo());
            
            ps.executeUpdate();
            resultado = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return resultado;
    }
    
    public Equipo obtenerEquipoPorId(int idEquipo){
        Equipo eq = null;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Equipos WHERE idEquipo = ?");
            ps.setInt(1, idEquipo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String nombre = rs.getString("nombre");
                
                eq = new Equipo(idEquipo, nombre);
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return eq;
    }
    
    public ArrayList<Jugador> listaJugadoresPorEquipo (int idEquipo){
        ArrayList<Jugador> lista = new ArrayList<>();
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT idJugador, j.nombre, apellido, edad, j.idPosicionJugador, dorsal, suspension, capitan, telefono, email \n" +
                                                        "FROM Jugadores j\n" +
                                                        "INNER JOIN PosicionesJugadores pj ON j.idPosicionJugador = pj.idPosicionJugador \n" +
                                                        "WHERE j.idEquipo = ?\n" +
                                                        "ORDER BY j.idPosicionJugador ASC");
            ps.setInt(1, idEquipo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int idJugador = rs.getInt("idJugador");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                int idPosicionJugador = rs.getInt("idPosicionJugador");
                PosicionJugador posicionJugador = obtenerPosicionJugador(idPosicionJugador);
                int dorsal = rs.getInt("dorsal");
                boolean suspension = rs.getBoolean("suspension");
                boolean capitan = rs.getBoolean("capitan");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                
                lista.add(new Jugador(idJugador, nombre, apellido, edad, posicionJugador, dorsal, suspension, capitan, telefono, email));
            }
            rs.close();
        }
        catch(Exception e){
           e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return lista;
    }
    
    // ----------------------------- CAMPO -------------------------------------
    
    public void altaCampo(Campo c){
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Campos VALUES (?)");
            ps.setString(1, c.getNombre());
            
            ps.executeUpdate();
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
    }
    
    public ArrayList<Campo> getListadoCampos(){
        ArrayList<Campo> lista = new ArrayList<>();
        try{
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Campos");
            while(rs.next()){
                int idCampo = rs.getInt("idCampo");
                String nombre = rs.getString("nombre");
                
                lista.add(new Campo(idCampo, nombre));
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return lista;
    }
    
    public boolean modificarCampo(Campo campo){
        boolean resultado = false;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Campos SET nombre = ? WHERE idCampo = ?");
            ps.setString(1, campo.getNombre());
            ps.setInt(2, campo.getIdCampo());
            
            ps.executeUpdate();
            resultado = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return resultado;
    }
    
    public Campo obtenerCampoPorId(int idCampo){
        Campo c = null;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Campos WHERE idCampo = ?");
            ps.setInt(1, idCampo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String nombre = rs.getString("nombre");
                
                c = new Campo(idCampo, nombre);
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return c;
    }
    
    // ------------------------------ NOVEDAD ----------------------------------
    
    public void altaNovedad(Novedad n){
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Novedades VALUES (?, ?)");
            ps.setString(1, n.getTitulo());
            ps.setString(2, n.getDescripcion());
            
            ps.executeUpdate();
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
    }
    
    public ArrayList<Novedad> getListadoNovedades(){
        ArrayList<Novedad> lista = new ArrayList<>();
        try{
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Novedades");
            while(rs.next()){
                int idNovedad = rs.getInt("idNovedad");
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                
                lista.add(new Novedad(idNovedad, titulo, descripcion));
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return lista;
    }
    
    public boolean modificarNovedad(Novedad novedad){
        boolean resultado = false;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Novedades SET titulo = ?, descripcion = ? WHERE idNovedad = ?");
            ps.setString(1, novedad.getTitulo());
            ps.setString(2, novedad.getDescripcion());
            ps.setInt(3, novedad.getIdNovedad());
            
            ps.executeUpdate();
            resultado = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return resultado;
    }
    
    public void eliminarNovedad(int idNovedad){
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("DELETE FROM Novedades WHERE idNovedad = ?");
            ps.setInt(1, idNovedad);
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
    }
    
    public Novedad obtenerNovedadPorId(int idNovedad){
        Novedad n = null;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Novedades WHERE idNovedad = ?");
            ps.setInt(1, idNovedad);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                
                n = new Novedad(idNovedad, titulo, descripcion);
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return n;
    }
    
    // ------------------------------- PARTIDO ---------------------------------
    
    public void altaPartido(Partido p){
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Partidos VALUES (?, ?, null, ?, ?, ?, ?, ?, null, null, 'false')");
            ps.setString(1, p.getFecha());
            ps.setString(2, p.getHora());
            ps.setInt(3, p.getEquipoLocal().getIdEquipo());
            ps.setInt(4, p.getEquipoVisitante().getIdEquipo());
            ps.setInt(5, p.getArbitro().getIdArbitro());
            ps.setInt(6, p.getCampo().getIdCampo());
            ps.setInt(7, p.getJornada());
            
            ps.executeUpdate();
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
    }
    
    public ArrayList<Jugador> getMvp(){
        ArrayList<Jugador> mvp = new ArrayList<>();
        try{
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Jugadores");
            while(rs.next()){
                int idJugador = rs.getInt("idJugador");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                int idPosicionJugador = rs.getInt("idPosicionJugador");
                PosicionJugador posicionJugador = obtenerPosicionJugador(idPosicionJugador);
                int dorsal = rs.getInt("dorsal");
                int idEquipo = rs.getInt("idEquipo");
                Equipo equipo = obtenerEquipo(idEquipo);
                boolean suspension = rs.getBoolean("suspension");
                boolean capitan = rs.getBoolean("capitan");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                
                mvp.add(new Jugador(idJugador, nombre, apellido, edad, posicionJugador, dorsal, equipo, suspension, capitan, telefono, email));
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return mvp;
    }
    
    public ArrayList<Arbitro> getArbitros(){
        ArrayList<Arbitro> arbitros = new ArrayList<>();
        try{
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Arbitros");
            while(rs.next()){
                int idArbitro = rs.getInt("idArbitro");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                
                arbitros.add(new Arbitro(idArbitro, nombre, apellido, telefono, email));
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return arbitros;
    }
    
    public ArrayList<Equipo> getEquipoLocalVisitante(){
        ArrayList<Equipo> equipos = new ArrayList<>();
        try{
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Equipos");
            while(rs.next()){
                int idEquipo = rs.getInt("idEquipo");
                String nombre = rs.getString("nombre");
                
                equipos.add(new Equipo(idEquipo, nombre));
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return equipos;
    }
    
    public ArrayList<Campo> getCampos(){
        ArrayList<Campo> campos = new ArrayList<>();
        try{
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Campos");
            while(rs.next()){
                int idCampo = rs.getInt("idCampo");
                String nombre = rs.getString("nombre");
                
                campos.add(new Campo(idCampo, nombre));
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return campos;
    }
    
    public Jugador obtenerMvp(int idJugador){
        Jugador j = null;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Jugadores WHERE idJugador = ?");
            ps.setInt(1, idJugador);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                int idPosicionJugador = rs.getInt("idPosicionJugador");
                PosicionJugador posicionJugador = obtenerPosicionJugador(idPosicionJugador);
                int dorsal = rs.getInt("dorsal");
                int idEquipo = rs.getInt("idEquipo");
                Equipo equipo = obtenerEquipo(idEquipo);
                boolean suspension = rs.getBoolean("suspension");
                boolean capitan = rs.getBoolean("capitan");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                j = new Jugador(idJugador, nombre, apellido, edad, posicionJugador, dorsal, equipo, suspension, capitan, telefono, email);
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return j;
    }
    
    public ArrayList<Jugador> obtenerJugadorPorPartido (int idPartido){
        ArrayList<Jugador> lista = new ArrayList<>();
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT idJugador, j.nombre, apellido, edad, idPosicionJugador, dorsal, j.idEquipo, suspension, capitan, telefono, email\n" +
                                                        "FROM Jugadores j\n" +
                                                        "INNER JOIN Equipos e ON j.idEquipo = e.idEquipo\n" +
                                                        "INNER JOIN Partidos p ON p.idEquipoLocal = e.idEquipo OR p.idEquipoVisitante = e.idEquipo\n" +
                                                        "WHERE idPartido = ?\n" +
                                                        "ORDER BY j.idEquipo, j.idPosicionJugador");
            ps.setInt(1, idPartido);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int idJugador = rs.getInt("idJugador");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");
                int idPosicionJugador = rs.getInt("idPosicionJugador");
                PosicionJugador posicionJugador = obtenerPosicionJugador(idPosicionJugador);
                int dorsal = rs.getInt("dorsal");
                int idEquipo = rs.getInt("idEquipo");
                Equipo equipo = obtenerEquipo(idEquipo);
                boolean suspension = rs.getBoolean("suspension");
                boolean capitan = rs.getBoolean("capitan");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                lista.add(new Jugador(idJugador, nombre, apellido, edad, posicionJugador, dorsal, equipo, suspension, capitan, telefono, email));
            }
            rs.close();
        }
        catch(Exception e){
           e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return lista;
    }
    
    public Arbitro obtenerArbitro(int idArbitro){
        Arbitro a = null;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Arbitros WHERE idArbitro = ?");
            ps.setInt(1, idArbitro);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");
                a = new Arbitro(idArbitro, nombre, apellido, telefono, email);
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return a;
    }
    
    public Campo obtenerCampo(int idCampo){
        Campo c = null;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Campos WHERE idCampo = ?");
            ps.setInt(1, idCampo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String nombre = rs.getString("nombre");
                c = new Campo(idCampo, nombre);
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return c;
    }
    
    public ArrayList<Partido> getListadoPartidos(){
        ArrayList<Partido> lista = new ArrayList<>();
        try{
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Partidos");
            while(rs.next()){
                int idPartido = rs.getInt("idPartido");
                int jornada = rs.getInt("jornada");
                String fecha = rs.getString("fecha");
                String hora = rs.getString("hora");
                int idMvp = rs.getInt("idMvp");
                Jugador mvp = obtenerMvp(idMvp);
                int idEquipoLocal = rs.getInt("idEquipoLocal");
                Equipo equipoLocal = obtenerEquipo(idEquipoLocal);
                int idEquipoVisitante = rs.getInt("idEquipoVisitante");
                Equipo equipoVisitante = obtenerEquipo(idEquipoVisitante);
                int idArbitro = rs.getInt("idArbitro");
                Arbitro arbitro = obtenerArbitro(idArbitro);
                int idCampo = rs.getInt("idCampo");
                Campo campo = obtenerCampo(idCampo);
                int resultadoEquipoLocal = rs.getInt("resultadoEquipoLocal");
                int resultadoEquipoVisitante = rs.getInt("resultadoEquipoVisitante");
                boolean estado = rs.getBoolean("estado");
                
                lista.add(new Partido(idPartido, fecha, hora, mvp, equipoLocal, equipoVisitante, arbitro, campo, jornada, resultadoEquipoLocal, resultadoEquipoVisitante, estado));
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return lista;
    }
    
    public boolean modificarPartido(Partido partido){
        boolean resultado = false;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Partidos SET fecha = ?, hora = ?, idEquipoLocal = ?, idEquipoVisitante = ?, idArbitro = ?, idCampo = ?, jornada = ? WHERE idPartido = ?");
            ps.setString(1, partido.getFecha());
            ps.setString(2, partido.getHora());
            ps.setInt(3, partido.getEquipoLocal().getIdEquipo());
            ps.setInt(4, partido.getEquipoVisitante().getIdEquipo());
            ps.setInt(5, partido.getArbitro().getIdArbitro());
            ps.setInt(6, partido.getCampo().getIdCampo());
            ps.setInt(7, partido.getJornada());
            ps.setInt(8, partido.getIdPartido());
            
            ps.executeUpdate();
            resultado = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return resultado;
    }
    
    public boolean resultadoPartido(Partido partido){
        boolean resultado = false;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Partidos SET idMvp = ?, resultadoEquipoLocal = ?, resultadoEquipoVisitante = ?, estado = 'true' WHERE idPartido = ?");
            ps.setInt(1, partido.getMvp().getIdJugador());
            ps.setInt(2, partido.getResultadoEquipoLocal());
            ps.setInt(3, partido.getResultadoEquipoVisitante());
            ps.setInt(4, partido.getIdPartido());
            
            ps.executeUpdate();
            resultado = true;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return resultado;
    }
    
    public Partido obtenerPartidoPorId(int idPartido){
        Partido p = null;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Partidos WHERE idPartido = ?");
            ps.setInt(1, idPartido);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String fecha = rs.getString("fecha");
                String hora = rs.getString("hora");
                int idMvp = rs.getInt("idMvp");
                Jugador mvp = obtenerMvp(idMvp);
                int idEquipoLocal = rs.getInt("idEquipoLocal");
                Equipo equipoLocal = obtenerEquipo(idEquipoLocal);
                int idEquipoVisitante = rs.getInt("idEquipoVisitante");
                Equipo equipoVisitante = obtenerEquipo(idEquipoVisitante);
                int idArbitro = rs.getInt("idArbitro");
                Arbitro arbitro = obtenerArbitro(idArbitro);
                int idCampo = rs.getInt("idCampo");
                Campo campo = obtenerCampo(idCampo);
                int jornada = rs.getInt("jornada");
                int resultadoEquipoLocal = rs.getInt("resultadoEquipoLocal");
                int resultadoEquipoVisitante = rs.getInt("resultadoEquipoVisitante");
                boolean estado = rs.getBoolean("estado");
                
                p = new Partido(idPartido, fecha, hora, mvp, equipoLocal, equipoVisitante, arbitro, campo, jornada, resultadoEquipoLocal, resultadoEquipoVisitante, estado);
            }
            rs.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return p;
    }
    
    public void eliminarPartido(int idPartido){
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("DELETE FROM Partidos WHERE idPartido = ?");
            ps.setInt(1, idPartido);
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
    }
    
    /* Crear método donde muestre las jornadas para la página Principal, debe tener
    parámetro por jornada */
    
    // ------------------------------ GOLES ------------------------------------
    
    public void altaGol(Gol g){
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Goles VALUES (?, ?, ?)");
            ps.setInt(1, g.getJugador().getIdJugador());
            ps.setInt(2, g.getMinuto());
            ps.setInt(3, g.getPartido().getIdPartido());
            
            ps.executeUpdate();
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
    }
    
    public ArrayList<Gol> listaGolesPorPartido (int idPartido){
        ArrayList<Gol> lista = new ArrayList<>();
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT *\n" +
                                                        "FROM Goles\n" +
                                                        "WHERE idPartido = ?\n" +
                                                        "ORDER BY minuto");
            ps.setInt(1, idPartido);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int idGol = rs.getInt("idGol");
                int idJugador = rs.getInt("idJugador");
                Jugador jugador = obtenerJugadorPorId(idJugador);
                int minuto = rs.getInt("minuto");
                
                lista.add(new Gol(idGol, jugador, minuto));
            }
            rs.close();
        }
        catch(Exception e){
           e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return lista;
    }
    
    public int cantidadGoles (int idPartido){
        int cantidad = 0;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT count(*) 'cantidad'\n" +
                                                        "FROM Goles\n" +
                                                        "WHERE idPartido = ?");
            ps.setInt(1, idPartido);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int cantidadGoles = rs.getInt("cantidad");
                return cantidad = cantidadGoles;
            }
            rs.close();
        }
        catch(Exception e){
           e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return cantidad;
    }
    
    public int cantidadGolesLocalYVisitante (int idPartido){
        int cantidad = 0;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT SUM(resultadoEquipoLocal + resultadoEquipoVisitante) 'cantidad'\n" +
                                                        "FROM Partidos\n" +
                                                        "WHERE idPartido = ?");
            ps.setInt(1, idPartido);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int cantidadGoles = rs.getInt("cantidad");
                return cantidad = cantidadGoles;
            }
            rs.close();
        }
        catch(Exception e){
           e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return cantidad;
    }
    
    public void eliminarGol(int idGol){
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("DELETE FROM Goles WHERE idGol = ?");
            ps.setInt(1, idGol);
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
    }
    
    // ------------------------ TARJETAS AMARILLAS -----------------------------
    
    public void altaTarjetaAmarilla(TarjetaAmarilla ta){
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO TarjetasAmarillas VALUES (?, ?, ?)");
            ps.setInt(1, ta.getJugador().getIdJugador());
            ps.setInt(2, ta.getMinuto());
            ps.setInt(3, ta.getPartido().getIdPartido());
            
            ps.executeUpdate();
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
    }
    
    public ArrayList<TarjetaAmarilla> listaTarjetasAmarillasPorPartido (int idPartido){
        ArrayList<TarjetaAmarilla> lista = new ArrayList<>();
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT *\n" +
                                                        "FROM TarjetasAmarillas\n" +
                                                        "WHERE idPartido = ?\n" +
                                                        "ORDER BY minuto");
            ps.setInt(1, idPartido);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int idTarjetaAmarilla = rs.getInt("idTarjetaAmarilla");
                int idJugador = rs.getInt("idJugador");
                Jugador jugador = obtenerJugadorPorId(idJugador);
                int minuto = rs.getInt("minuto");
                
                lista.add(new TarjetaAmarilla(idTarjetaAmarilla, jugador, minuto));
            }
            rs.close();
        }
        catch(Exception e){
           e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return lista;
    }
    
    public int cantidadTarjetasAmarillas (int idPartido){
        int cantidad = 0;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT count(*) 'cantidad'\n" +
                                                        "FROM TarjetasAmarillas\n" +
                                                        "WHERE idPartido = ?");
            ps.setInt(1, idPartido);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int cantidadTarjetas = rs.getInt("cantidad");
                return cantidad = cantidadTarjetas;
            }
            rs.close();
        }
        catch(Exception e){
           e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return cantidad;
    }
    
    public void eliminarTarjetaAmarilla(int idTarjetaAmarilla){
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("DELETE FROM TarjetasAmarillas WHERE idTarjetaAmarilla = ?");
            ps.setInt(1, idTarjetaAmarilla);
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
    }
    
    // -------------------------- TARJETAS ROJAS -------------------------------
    
    public void altaTarjetaRoja(TarjetaRoja tr){
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO TarjetasRojas VALUES (?, ?, ?, ?)");
            ps.setInt(1, tr.getJugador().getIdJugador());
            ps.setInt(2, tr.getMinuto());
            ps.setInt(3, tr.getPartido().getIdPartido());
            ps.setString(4, tr.getMotivo());
            
            ps.executeUpdate();
            ps.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
    }
    
    public ArrayList<TarjetaRoja> listaTarjetasRojasPorPartido (int idPartido){
        ArrayList<TarjetaRoja> lista = new ArrayList<>();
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT *\n" +
                                                        "FROM TarjetasRojas\n" +
                                                        "WHERE idPartido = ?\n" +
                                                        "ORDER BY minuto");
            ps.setInt(1, idPartido);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int idTarjetaRoja = rs.getInt("idTarjetaRoja");
                int idJugador = rs.getInt("idJugador");
                Jugador jugador = obtenerJugadorPorId(idJugador);
                int minuto = rs.getInt("minuto");
                String motivo = rs.getString("motivo");
                
                lista.add(new TarjetaRoja(idTarjetaRoja, jugador, minuto, motivo));
            }
            rs.close();
        }
        catch(Exception e){
           e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return lista;
    }
    
    public void eliminarTarjetaRoja(int idTarjetaRoja){
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("DELETE FROM TarjetasRojas WHERE idTarjetaRoja = ?");
            ps.setInt(1, idTarjetaRoja);
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
    }
    
    public int cantidadTarjetasRojas (int idPartido){
        int cantidad = 0;
        try{
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT count(*) 'cantidad'\n" +
                                                        "FROM TarjetasRojas\n" +
                                                        "WHERE idPartido = ?");
            ps.setInt(1, idPartido);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int cantidadTarjetas = rs.getInt("cantidad");
                return cantidad = cantidadTarjetas;
            }
            rs.close();
        }
        catch(Exception e){
           e.printStackTrace();
        }
        finally{
            cerrarConexion();
        }
        return cantidad;
    }
}
