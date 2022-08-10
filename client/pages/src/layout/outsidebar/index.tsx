import OutSideBarContainer from "./container";

interface IOutSideBarProps {
  onClickMoveToMain: () => void;
  onClickMoveToChannel: () => void;
}

export default function OutSideBar(props: IOutSideBarProps) {
  return (
    <OutSideBarContainer
      onClickMoveToMain={props.onClickMoveToMain}
      onClickMoveToChannel={props.onClickMoveToChannel}
    />
  );
}
