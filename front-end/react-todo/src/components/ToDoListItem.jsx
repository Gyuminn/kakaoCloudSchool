import {
  MdCheckBoxOutlineBlank,
  MdCheckBox,
  MdRemoveCircleOutline,
} from "react-icons/md";

import cn from "classnames";
import "./ToDoListItem.scss";

import React, { useCallback } from "react";

const ToDoListItem = ({ todo, handleRemove, handleToggle, style }) => {
  const { id, text, checked } = todo;

  const handleDelete = useCallback(
    (e) => {
      const result = window.confirm(`${text}를 정말로 삭제하시겠습니까?`);
      if (result) {
        handleRemove(id);
      }
    },
    [handleRemove, id, text]
  );

  return (
    <div className="ToDoListItem-virtualized" style={style}>
      <div className="ToDoListItem">
        <div
          className={cn("checkbox", { checked })}
          onClick={(e) => handleToggle(id)}
        >
          {checked ? <MdCheckBox /> : <MdCheckBoxOutlineBlank />}
          <div className="text">{text}</div>
        </div>
        <div className="remove" onClick={handleDelete}>
          <MdRemoveCircleOutline />
        </div>
      </div>
    </div>
  );
};

export default React.memo(ToDoListItem);
