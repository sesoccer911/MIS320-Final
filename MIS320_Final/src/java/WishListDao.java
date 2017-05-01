
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * Evan
 */
public class WishListDao
{
    private Connection connection;

    public WishListDao() {
        connection = DbConnectionUtil.getConnection();
    }

    public void deleteProduct(int wishItems_id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM wishlistitems WHERE wishItems_id=?");

            String wishItem = "" + wishItems_id;
            preparedStatement.setString(1, wishItem);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
