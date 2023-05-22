/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package INTERFACES;

import java.util.List;

/**
 *
 * @author User
 */
public interface ObligacionBD<m> {
    public boolean create(m nuevo);

    public List<m> readAll();

    public m read(m filter);

    public boolean update(m item);

    public boolean delete(m item);

}
