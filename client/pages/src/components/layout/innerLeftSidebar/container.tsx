import React, { useState } from "react";
import InnerLeftSideBarPresenter from "./presenter";

interface IInnerLeftSideBarProps {
  inServer: boolean;
  serverName: string;
}

export default function InnerLeftSideBarContainer(
  props: IInnerLeftSideBarProps
) {
  const [opened, setOpened] = useState<string[]>([]);
  const onClickGroupOpen = (event: React.MouseEvent<HTMLDivElement>) => {
    const newList = [...opened];
    if (newList.includes((event.target as HTMLDivElement).id)) {
      setOpened(
        newList.filter((el) => el !== (event.target as HTMLDivElement).id)
      );
    } else {
      newList.push((event.target as HTMLDivElement).id);
      setOpened(newList);
    }
  };

  return (
    <InnerLeftSideBarPresenter
      inServer={props.inServer}
      serverName={props.serverName}
      opened={opened}
      onClickGroupOpen={onClickGroupOpen}
    />
  );
}
