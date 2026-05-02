public class FRQ2304{

}

class Candy{

}

class BoxOfCandy{
    public boolean moveCandyToFirstRow(int col)
    {
        // jika sudah ada candy di baris 0
        if (box[0][col] != null)
        {
            return true;
        }

        // cari candy di bawahnya
        for (int r = 1; r < box.length; r++)
        {
            if (box[r][col] != null)
            {
                box[0][col] = box[r][col];
                box[r][col] = null;
                return true;
            }
        }

        return false;
    }

    public Candy removeNextByFlavor(String flavor)
    {
        for (int r = box.length - 1; r >= 0; r--)
        {
            for (int c = 0; c < box[0].length; c++)
            {
                if (box[r][c] != null &&
                    box[r][c].getFlavor().equals(flavor))
                {
                    Candy temp = box[r][c];
                    box[r][c] = null;
                    return temp;
                }
            }
        }

        return null;
    }
}