import { useEffect } from "react";
import { createServer, getServer } from "./post";
import OutSideBarPresenter from "./presenter";

interface IOutSideBarProps {
  dummy: { name: string; member: string[] }[];
  onClickMoveToMain: () => void;
  onClickMoveToChannel: (event: React.MouseEvent<HTMLDivElement>) => void;
}

export default function OutSideBarContainer(props: IOutSideBarProps) {
  const onClickCreateServer = () => {
    createServer();
  };

  useEffect(() => {
    getServer();
  }, []);

  return (
    <OutSideBarPresenter
      dummy={props.dummy}
      onClickMoveToMain={props.onClickMoveToMain}
      onClickMoveToChannel={props.onClickMoveToChannel}
      onClickCreateServer={onClickCreateServer}
    />
  );
}
