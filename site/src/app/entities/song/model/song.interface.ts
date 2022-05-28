export interface ISong {
  id?: number | undefined;
  name: string;
  image?: string;
  duration: number;
  rating?: number;
  artist: IArtist;
  album: IAlbum;
  style: IStyle;
  reproductions?: number;
  inclusionDate?: Date;
}

export interface IArtist {
  name?: string;
  id: number;
}

export interface IAlbum {
  title?: string;
  id: number;
}

export interface IStyle {
  name?: string;
  id: number;
}
