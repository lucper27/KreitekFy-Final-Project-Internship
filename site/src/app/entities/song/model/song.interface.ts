export interface ISong {
  id?: number | undefined;
  name: string;
  image?: string;
  duration: number;
  rating?: number;
  artistName: string;
  artistId?: number;
  albumName: string;
  albumId?: number;
  styleName: string;
  styleId?: number;
  reproductions?: number;
  added?: Date ;
}
